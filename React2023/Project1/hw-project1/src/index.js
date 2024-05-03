import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

import MangaMain from "./MainPage";
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import MangaPage from "./MangaPage/MangaPage";
import Genrelist from "./GenreList/genrelist";
import LogRegPage from "./LogReg/LogRegPage";
import MyPage from "./Mypage/Mypage";
import Admaker from "./Ad/Admaker";


const root = ReactDOM.createRoot(document.getElementById('root'));
const router = createBrowserRouter([
    {
        path: '/MangaPage/:id',
        element: <MangaPage/>
    },
    {
        path: '/',
        element: <MangaMain/>
    },
    {
        path: '/genre/:id',
        element: <Genrelist/>
    },
    {
        path: '/signupin/:mode',
        element: <LogRegPage/>
    },
    {
        path: '/myPage',
        element: <MyPage/>
    },
    {
        path: '/adMaker',
        element: <Admaker/>
    }
]);


root.render(
    <RouterProvider router={router} />
);

reportWebVitals();
