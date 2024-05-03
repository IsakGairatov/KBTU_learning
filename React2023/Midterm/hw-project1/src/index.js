import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import HomePage from "./Components/Home";
import Lenta from "./Components/Lenta";


const root = ReactDOM.createRoot(document.getElementById('root'));
const router = createBrowserRouter([
    {
        path: '/',
        element: <HomePage/>
    },
    {
        path: 'Posts',
        element: <Lenta/>
    },
    {
        path: 'User:id'
        element:
    }
]);


root.render(
    <RouterProvider router={router} />
);

reportWebVitals();
