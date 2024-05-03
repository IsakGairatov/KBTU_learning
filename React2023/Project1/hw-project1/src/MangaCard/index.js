import {Button, Card, Image, Space} from "antd";
import React from "react";

import {Link} from "react-router-dom";
import {Genres} from "../Data/MockApi.js";



const MangaCard = (props) => {
    const { id, name, img, author, artist, year, desc, genres } = props;

    return (
        <Card>
            <Space direction="horizontal">
            <img src={img} alt={""} width="300"/>
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
                    <Link to={"/MangaPage/" + id}>
                        <Button>Подробнее</Button>
                    </Link>
                </div>
            </Space>
        </Card>
    );
};



export default MangaCard;