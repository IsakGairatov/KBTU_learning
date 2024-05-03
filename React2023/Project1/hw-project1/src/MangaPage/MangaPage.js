import {Card, Space} from "antd";
import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import MangaCard2 from "../MangaCard/index2";
import {CharactersList, MangaList} from "../Data/MockApi.js";
import Character from "../MangaCard/character";
import Hat from "../MainPage/Hat";
import {collection, doc, getDoc, getDocs} from "firebase/firestore";
import {db} from "../Firebs/FireBaser";
import Comment from "./comments";
import CommentWriter from "./commentWrite";
import AdPage from "../Ad/AdPage";



const MangaPage = () => {
    let {id} = useParams();
    const mangaRef = doc(db, "MangaList", id)
    const [manga, setManga] = useState([])

    const commentRef = collection(db, "comments")
    const [coms, setcoms] = useState([])

    const getManga = async () => {
        try {
            const data = await getDoc(mangaRef);
            const fdata = data.data()
            fdata.id = data.id
            setManga([fdata])
        } catch (err) {
            console.error(err);
        }

    }

    const getComs = async () => {
        try {
            const data = await getDocs(commentRef);
            const fdata = data.docs.map((doc) => ({
                ...doc.data(),
                id: doc.id,
            }))
            setcoms(fdata)
        } catch (err) {
            console.error(err);
        }
    }

    useEffect(
        () => {
            getManga();
            getComs();
        }, []
    )

    let list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].map((n) =>
        ([n , `C:\\Users\\Gayrat\\Desktop\\programming\\5semester\\React2023\\Project1\\hw-project1\\src\\Data\\Chapters\\${1}"\\${n}.pdf`.toString()]))

    list = list.map((el) => (
        [el[0], require("C:\\Users\\Gayrat\\Desktop\\programming\\5semester\\React2023\\Project1\\hw-project1\\src\\Data\\Chapters\\1\\1.pdf")]
    ))

    return (
        <>  <AdPage/>
            <Hat/>
            {manga.map((element) => (
                <MangaCard2
                    {...element}
                />
            ))}
            <Card>
                <h1><b>Персонажи:</b></h1>
                <Space direction="horizontal">
                    {CharactersList.find((el) => el.id == id).characters.map((elements) => (
                        <Character {...elements}/>
                        ))}
                </Space>

                <br/>
                <Space direction={"vertical"}>
                    <h1>Главы:</h1>
                    {list.map((el) =>
                        (<a href={el[1]} download>Скачать главу {el[0]}</a>))}
                </Space>
                <Card>
                    <Space direction={"vertical"}>
                        <h1>Комментарии:</h1>
                        <CommentWriter {...{id}}/>
                        {coms.filter((c) => c.MangaId == id).map((el) => (
                            <Comment{...el}/>
                        ))}
                    </Space>
                </Card>


            </Card>
        </>
        );
};

export default MangaPage;