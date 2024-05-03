import {initializeApp} from "firebase/app"
import {getAuth} from 'firebase/auth'
import {getFirestore} from "firebase/firestore"


const firebaseConfig = {
    apiKey: "AIzaSyBmAjM2xcERzd6Jj-utkSaavUKkXzMC5TA",
    authDomain: "messanger-8db99.firebaseapp.com",
    projectId: "messanger-8db99",
    storageBucket: "messanger-8db99.appspot.com",
    messagingSenderId: "1066580871529",
    appId: "1:1066580871529:web:417e5699628e0764b555f8",
    measurementId: "G-86WEYBE3WK"
};

const app = initializeApp(firebaseConfig);
export const auth = getAuth(app);
export const db = getFirestore(app);

