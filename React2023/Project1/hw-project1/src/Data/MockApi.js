import {toArray} from "antd/es/form/util";
import {json} from "react-router-dom";

import "./Jsons/Db.json"
import {useState} from "react";

export const MangaList = [
  {
    "id": 1,
    "name": "Радиант",
    "img": require('./MangaCovers/Radiant1.png'),
    "author": "Тони Валант",
    "artist": "Тони Валант",
    "year": "2013",
    "desc": "В мире, где на землю снизошёл гнев небес и появились мстители, человечество пытается из последних сил выжить… Как бы противно и страшно людям не было, но они вынуждены сотрудничать с существами, не менее опасными и ужасающими, чем пришельцы… С проклятыми изгоями общества, с колдунами! Сет – молодой, энергичный ученик колдуна, бравый парень, пытающийся под началом своего учителя уничтожить своего первого мстителя…",
    "genres": ["боевик", "приключение", "комедия", "сёнэн"]
  },
  {
    "id": 2,
    "name": "Наша драгоценная история",
    "img": require('./MangaCovers/PreciosConv.png'),
    "author": "Робико",
    "artist": "Робико",
    "year": "2015",
    "desc": "Молчаливая старшеклассница Аизава влюблена в Азуму-куна, парня из параллельного класса, и однажды на железнодорожной станции она говорит ему то, чего он услышать не ожидал...",
    "genres": ["комедия", "повседневность", "романтика", "сёдзё", "школа"]
  },
  {
    "id": 3,
    "name": "Я требую яоя",
    "img": require('./MangaCovers/KissHim.png'),
    "author": "Дзюнко",
    "artist": "Дзюнко",
    "year": "2013",
    "desc": "Сэринума Каэ — толстая и некрасивая школьница, и к тому же злостная яойщица, обожающая искать «намёки» в поведении одноклассников… В один прекрасный день из-за смерти любимого аниме-персонажа она быстро сбрасывает вес и становится популярной, особенно у Синомии-куна и Мицуми-сэмпая… Как же сложатся романтические отношения девушки",
    "genres": ["комедия", "гарем", "романтика", "школа", "сёдзё"]

  },
  {
    "id": 4,
    "name": "Повелитель",
    "img": require('./MangaCovers/Overlord.png'),
    "author": "Маруйама Кагане",
    "artist": "Маруйама Кагане",
    "year": "2014",
    "desc": "Когда-то онлайн игра Иггдрасиль, о которой рассказывается в сюжете манги «Повелитель», была достаточно популярной. В нее играло много людей и Момонга являлся одним из самых преданных фанатов проекта. Но из-за не слишком больших прибылей (или по каким-то другим причинам) разработчики решили закрыть Иггдрасиль, и приближался момент, когда Момонге пришлось бы попрощаться с полюбившимся миром. Но неожиданно он осознал, что проект не прекратил свое существование. Так как игрок находился в момент, якобы, закрытия…",
    "genres": ["боевик", "приключение", "фэнтези", "сёнэн"]
  },
  {
    "id": 5,
    "name": "Моя реинкарнация в отомэ-игру в качестве главной злодейки ",
    "img": require('./MangaCovers/Bakarina.png'),
    "author": "Ямогути Сатору",
    "artist": "Хидака Нами",
    "year": "2017",
    "desc": "«Хорошенько приложившись о камень, я вспомнила свою прошлую жизнь. Я, Катарина Клаес, восьмилетняя дворянка, в прошлом обычная семнадцатилетняя школьница-отаку, после смерти попала… в отомэ-игру, в которой я зависала в прошлой жизни. И кто же я по сценарию? Отъявленная Злодейка, главный отрицательный персонаж! А у плохих ребят, как правило, не бывает хэппи-энда…»",
    "genres": ["комедия", "фэнтези", "гарем", "романтика", "повседневность"]
  },
  {
    "id": 6,
    "name": "Богиня благословляет этот прекрасный мир мир",
    "img": require('./MangaCovers/Konosuba.png'),
    "author": "Акацуки Нацумэ",
    "artist": "Ватари Масахито",
    "year": "2014",
    "desc": "Пропадать — так с музыкой, выбирать — так богиню! Когда игроман-затворник, Сато Кадзума, окончил (преждевременно) свои дни на грешной земле, то очнулся в межреальности, где ехидная богиня Аква сделала ему предложение, от которого трудно отказаться. Да, вместо перерождения в жука или муху Кадзума получил шанс отправиться в игровой мир и «поработать по специальности», победив местного Князя Тьмы. Юному герою разрешили взять с собой что-то одно: и парень выбрал Акву — а нечего было выпендриваться! Начальство выбор утвердило — за слова надо отвечать, и парочка попаданцев отправилась на подвиги.\n" +
        "\n" +
        "На месте выяснилось, что попали ребята в тихие края, где о Темном Властелине только слышали. Ну и отлично — квест не терпит суеты, сначала надо осмотреться, потом спокойно обретать знания, копить навыки и качать опыт. Биться все равно придется — а значит, пора собирать группу, благо теория хорошо известна. Сам Кадзума, конечно, не мрачный воин, а скорее веселый вор, Аква как водная богиня потянет на целительницу, а главной огневой силой стала малышка Мэгумин, она же «Искусство — это взрыв!» Последней к компании прибилась Даркнес — уникальный рыцарь-мазохист. Да, с такими кадрами на Сатану идти не страшно — хуже уже не будет!",
    "genres": ["комедия", "фэнтези", "гарем", "романтика", "приключение", "этти"]
  }
];

export const CharactersList = [
  {
    id: "2dHg725a2ytCEEYmI5SR",
    characters: [
      { id: 1,
        name: "Сет",
        imgl: require("./Characters/1/set.png")
      },
      { id: 2,
        name: "Милли",
        imgl: require("./Characters/1/milly.png")
      },
      { id: 3,
        name: "Док",
        imgl: require("./Characters/1/dok.png")
      },
    ]
  },
  {
    id: "8ZNdL6RedLe3snPgVVOh",
    characters: [
      {id: 1,
      name: "Нодзоми Аидзава",
      imgl: "https://desu.shikimori.one/uploads/poster/characters/140243/preview-764d9aaf40abd9ec654faa28a723d661.webp"},
      {id: 2,
        name: "Сиро Адзума",
        imgl: "https://desu.shikimori.one/uploads/poster/characters/140244/preview-912dd2374312a3353b938b797f7b3d0f.webp"}
    ]
  },
  {
    id: "G2VWqR80pSigQbduaWvP",
  characters: [
    {id: 1,
    name: "Асума Муцуми",
    imgl: "https://desu.shikimori.one/uploads/poster/characters/103335/preview-b3b31f8808975d62b02abb645f06647a.webp"},
    {id: 2,
      name: "Хаято Шиномия",
      imgl: "https://desu.shikimori.one/uploads/poster/characters/103341/preview-72080677568c615a9b8527be8116cbae.webp"},
    {id: 3,
      name: "Каэ Сэринума",
      imgl: "https://desu.shikimori.one/uploads/poster/characters/103333/preview-af16fa1b65b47cc42e13318857b71c28.webp"},
    {id: 4,
      name: "Нозому Нанашима",
      imgl: "https://desu.shikimori.one/uploads/poster/characters/103339/preview-3b23678b283a2290f711cce101a90c7d.webp"},
    {id: 5,
      name: "Шима Нишина",
      imgl: "https://desu.shikimori.one/uploads/poster/characters/130094/preview-d6e212e60c3326f5ba9917543f145d46.webp"},
    {id: 6,
      name: "Юскэ Игараши",
      imgl: "https://desu.shikimori.one/uploads/poster/characters/103337/preview-9c9c4bfc39695af7e490e84e537e2f4a.webp"}

  ]
  },
  {
    id: "dliR0MfzhMLVGa77cifg",
    characters: [
      {id: 1,
        name: "Альбедо",
        imgl: "https://desu.shikimori.one/uploads/poster/characters/116275/preview-7c89c26a7b0d0df5bb13f500bbc8ac82.webp"},
      {id: 2,
        name: "Момонга",
        imgl: "https://desu.shikimori.one/uploads/poster/characters/116281/preview-6eb30ff64b355e243339c3c89a6890f2.webp"}
    ]
  },
  {
    id: "l8GA4NNzvRYM4VvpLKiX",
    characters: [
      {id: 1,
        name: "Алан Стюарт",
        imgl: "https://desu.shikimori.one/uploads/poster/characters/166520/preview-e82bbba8ee167120411e691a3cf990f7.webp"},
      {id: 2,
        name: "Катарина Клаес",
        imgl: "https://desu.shikimori.one/uploads/poster/characters/159166/preview-b8c10e7553a7312895a96312f8645953.webp"},
      {id: 3,
        name: "Джордо Стюарт",
        imgl: "https://desu.shikimori.one/uploads/poster/characters/166519/preview-1dd3851ca7619b50182cde0f9fe98f3d.webp"},
      {id: 4,
        name: "Кит Клаес",
        imgl: "https://desu.shikimori.one/uploads/poster/characters/166521/preview-851709e215910ba49265ce98c79c9c7a.webp"},
      {id: 5,
        name: "Мария Кэмпбелл",
        imgl: "https://desu.shikimori.one/uploads/poster/characters/166523/preview-8bf2532c02c52b80dfa053c75a53795d.webp"},
      {id: 6,
        name: "Мэри Хант",
        imgl: "https://desu.shikimori.one/uploads/poster/characters/166525/preview-fe759befef13c774e30edaa2517c5402.webp"},
      {id: 7,
        name: "Николь Аскарт",
        imgl: "https://desu.shikimori.one/uploads/poster/characters/166522/preview-e1c1856f86b83983d51807fc83a5c26f.webp"},
      {id: 8,
        name: "София Аскарт",
        imgl: "https://desu.shikimori.one/uploads/poster/characters/166526/preview-fdfe40df3d5ab531632950cb69407f5a.webp"}
    ]
  },
  {
    id: "gBghvf2mzcBuhhlTAVEP",
    characters: [
      {id: 1,
        name: "Аква",
        imgl: "https://desu.shikimori.one/uploads/poster/characters/117223/preview-93e241b9868e776045cb4b28ffcf3223.webp"},
      {id: 2,
        name: "Казума Сато",
        imgl: "https://desu.shikimori.one/uploads/poster/characters/117221/preview-0a7684b586e8b42e40d04eb2c5877587.webp"},
      {id: 3,
        name: "Лалатина Дастинесс Форд",
        imgl: "https://desu.shikimori.one/uploads/poster/characters/117285/preview-cd035b47829233fccae6e4c97edaeb99.webp"},
      {id: 4,
        name: "Мэгумин",
        imgl: "https://desu.shikimori.one/uploads/poster/characters/117225/preview-637ba4b880519922dcdaaa6c0b2d9a9a.webp"},
    ]
  }
  ];


  export const Genres = [
  {id: 1,
  genre: "боевик"},
  {id: 2,
    genre: "приключение"},
  {id: 3,
    genre: "комедия"},
  {id: 4,
    genre: "сёнэн"},
  {id: 5,
    genre: "повседневность"},
  {id: 6,
    genre: "сёдзё"},
  {id: 7,
    genre: "школа"},
  {id: 8,
    genre: "гарем"},
  {id: 9,
    genre: "фэнтези"},
  {id: 10,
    genre: "этти"},
    {id: 11,
      genre: "романтика"
    }
]


const Db = require("./Jsons/Db.json")

export const Users = Db.Users

