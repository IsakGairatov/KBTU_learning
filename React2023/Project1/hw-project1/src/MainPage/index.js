import React, {useEffect, useState} from "react";
import {MangaList} from "../Data/MockApi.js";
import MangaCard from "../MangaCard";
import Hat from "./Hat";
import AdPage from "../Ad/AdPage";
import {Space} from "antd";
import {getDocs, collection, addDoc} from "firebase/firestore"
import {db} from "../Firebs/FireBaser";

const MangaMain = () => {
    const mangaCollectionRef = collection(db, "MangaList")
    const [mList, setMangaList] = useState([])
    const [mangas, setMangas] = useState([]);
    const getMangaList = async () => {
        try {
            const data = await getDocs(mangaCollectionRef);
            const fdata = data.docs.map((doc) => ({
                ...doc.data(),
                id: doc.id,
            }))
            setMangaList(fdata)
            setMangas(fdata)
        } catch (err) {
            console.error(err);
        }

    }
    useEffect(() => {
        getMangaList();
    }, [])




    const copy = async () => {
        try {
            await addDoc(mangaCollectionRef, {
                name: "Богиня благословляет этот прекрасный мир мир",
                img: "https://mangadex.org/covers/bcfa196d-d162-45f5-a224-61d26b04a077/1d3639cd-0bb7-4fbf-9530-525a19dc98bd.jpg",
                author: "Акацуки Нацумэ",
                artist: "Ватари Масахито",
                year: "2014",
                desc: "Пропадать — так с музыкой, выбирать — так богиню! Когда игроман-затворник, Сато Кадзума, окончил (преждевременно) свои дни на грешной земле, то очнулся в межреальности, где ехидная богиня Аква сделала ему предложение, от которого трудно отказаться. Да, вместо перерождения в жука или муху Кадзума получил шанс отправиться в игровой мир и «поработать по специальности», победив местного Князя Тьмы. Юному герою разрешили взять с собой что-то одно: и парень выбрал Акву — а нечего было выпендриваться! Начальство выбор утвердило — за слова надо отвечать, и парочка попаданцев отправилась на подвиги.\n" +
                    "\n" +
                    "На месте выяснилось, что попали ребята в тихие края, где о Темном Властелине только слышали. Ну и отлично — квест не терпит суеты, сначала надо осмотреться, потом спокойно обретать знания, копить навыки и качать опыт. Биться все равно придется — а значит, пора собирать группу, благо теория хорошо известна. Сам Кадзума, конечно, не мрачный воин, а скорее веселый вор, Аква как водная богиня потянет на целительницу, а главной огневой силой стала малышка Мэгумин, она же «Искусство — это взрыв!» Последней к компании прибилась Даркнес — уникальный рыцарь-мазохист. Да, с такими кадрами на Сатану идти не страшно — хуже уже не будет!",
                genres: ["комедия", "фэнтези", "гарем", "романтика", "приключение", "этти"]
            });
            console.log("bh")
            getMangaList()
        } catch (err) {
            console.log(err)
        }
    }


    const search = (event) => {
        var text = event.target.value.toLowerCase()
        setMangas(mList.filter((m) => (
            m.name.toLowerCase().match(text) || m.artist.toLowerCase().match(text) || m.author.toLowerCase().toLowerCase().match(text) || m.year.match(text) || m.desc.match(text)
        )))
    };





    return ( <>
            <Space direction={"vertical"}>
                <AdPage/>
                <Hat/>
                <input placeholder="Название манги" onChange={search} size={100}/>
            </Space>

            {mangas.map((element) => (
                <MangaCard
                    {...element}
                />
            ))}
    </>
    )
}

export default MangaMain;