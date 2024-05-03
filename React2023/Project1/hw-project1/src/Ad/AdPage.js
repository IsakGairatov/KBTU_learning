import React, {useEffect, useState} from "react";
import {Card, Space} from "antd";
import Meta from "antd/es/card/Meta";
import {collection, getDocs} from "firebase/firestore";
import {db} from "../Firebs/FireBaser";


const AdPage = () => {
    const adCollRef = collection(db, "ad")
    const [ad, setAd] = useState([]);


    const getAds = async() => {
        try {
            const data = await getDocs(adCollRef);
            const fdata = data.docs.map((doc) => ({
                ...doc.data(),
                id: doc.id,
            }))
            setAd(fdata)
        } catch (err) {
            console.error(err);
        }
    }

    useEffect(() => {
        getAds();
    }, [])


    return (<div>

            <Space direction={"horizontal"}>
                <a href={ad[0]?.url}>
                <Card>
                    <img
                        src={ad[0]?.img}
                        height={200}/>
                    <Meta title={ad[0]?.title} description={ad[0]?.desc}/>

                </Card></a>
            </Space>
        </div>
    )
}

export default AdPage