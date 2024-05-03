import {Button, Card, Space} from "antd";
import {Link} from "react-router-dom";
import {Genres} from "../Data/MockApi";
import {doc, setDoc} from "firebase/firestore"
import {auth, db} from "../Firebs/FireBaser";

const MangaCard2 = (props) => {
    const { id, name, img, author, artist, year, desc, genres } = props;
    const UserUMRef = doc(db, "MangaofUsers", id + auth.currentUser?.email)
    const save = async() => {
        try {
           await setDoc(UserUMRef, {
               User : auth.currentUser?.email,
               MangaId : id
           });
        } catch (err) {
            console.log(err)
        }
    }

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
                    <Button onClick={save}>Сохранить</Button>
                </div>
            </Space>
        </Card>
    );
};

export default MangaCard2;