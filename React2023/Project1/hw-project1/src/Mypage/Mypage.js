import {auth, db} from "../Firebs/FireBaser";
import {collection, getDocs} from "firebase/firestore";
import React, {useEffect, useState} from "react";
import {Genres} from "../Data/MockApi";
import MangaCard3 from "../MangaCard/index3";
import Hat from "../MainPage/Hat";
import AdPage from "../Ad/AdPage";

const MyPage = () => {
    const mangaCollectionRef = collection(db, "MangaList")
    const UserMangaRef = collection(db, "MangaofUsers")
    const [mList, setMangaList] = useState([])
    const [UserM, setUM] = useState([])


    const getMangaList = async () => {
        try {
            const data = await getDocs(mangaCollectionRef);
            const fdata = data.docs.map((doc) => ({
                ...doc.data(),
                id: doc.id,
            }))
            setMangaList(fdata)
        } catch (err) {
            console.error(err);
        }
    }


    const getUM = async () => {
        try {
            const data = await getDocs(UserMangaRef);
            const fdata = data.docs.map((doc) => ({
                ...doc.data(),
                id: doc.id,
            }))

            setUM(fdata.filter((um) => um.User == auth.currentUser.email))
        } catch (err) {
            console.error(err);
        }

    }

    useEffect(() => {
        getMangaList();
        getUM();
    }, [])

    return (
        <div>
            <AdPage/>
            <Hat/>
            <h1>Ваш Email: {auth.currentUser.email
            }</h1>

            {UserM.map((element) => (
                <MangaCard3
                    {...mList.find((el) => el.id === element.MangaId)}
                />
            ))}
        </div>

    )
}

export default MyPage;