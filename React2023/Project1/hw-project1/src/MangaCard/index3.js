import {Button, Card, Space} from "antd";
import {Link, useNavigate} from "react-router-dom";
import {Genres} from "../Data/MockApi";
import {auth, db} from "../Firebs/FireBaser";
import {deleteDoc, doc} from "firebase/firestore"
import useForceUpdate from "antd/es/_util/hooks/useForceUpdate";
import {render} from "react-dom";
import React from "react";


const MangaCard3 = (props) => {
    const { id, name, img, author, artist, year, desc, genres } = props;
    const nav = useNavigate()
    const del = async() => {
        try {
            await deleteDoc(doc(db, "MangaofUsers", id + auth.currentUser?.email));
            nav('/')
        } catch (err) {
            console.log(err)
        }

    }


    return (
        <Card>
            <Space direction="horizontal">
                <Link to={"/MangaPage/" + id}>
                <img src={img} alt={""} width="300"/></Link>
                <div>
                    <h1>{name}</h1>
                    <p>Сценарист: {author} <br/>
                        Художник: {artist}</p>
                    <p>год выпуска: {year}</p>
                    <p>Жанры:</p>
                    <Space direction="horizontal">
                        {genres.map((element) => (
                            <Link to={"/genre/" + Genres.find((g) => g.genre===element)?.id}>
                                <p>{element}</p>
                            </Link>
                        ))}
                    </Space>
                    <p>Описание:</p>
                    <p>{desc}</p>
                </div>
                <div>
                    <Button onClick={del}>Удалить</Button>
                </div>
            </Space>
        </Card>
    );
};

export default MangaCard3;