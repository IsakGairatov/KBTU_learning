import {MangaList} from "../Data/MockApi.js";
import MangaCard from "../MangaCard";
import React, {useEffect, useState} from "react";
import {Link, useParams} from "react-router-dom";
import {Genres} from "../Data/MockApi.js";
import Hat from "../MainPage/Hat";
import {collection, getDocs} from "firebase/firestore";
import {db} from "../Firebs/FireBaser";

const GenreList = () => {
    let {id} = useParams();
    const mangaCollectionRef = collection(db, "MangaList")
    const [mList, setMangaList] = useState([])

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
    useEffect(() => {
        getMangaList();
    }, [])

    return ( <>
            <Hat/><br/>

            <h1>Жанр {Genres[id - 1].genre}:</h1>
            {mList.filter((ml) => ml.genres.includes(Genres.find((g) => g.id==id).genre)).map((element) => (
                <MangaCard
                    {...element}
                />
            ))}
        </>
    )
}

export default GenreList;