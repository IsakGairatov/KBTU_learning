import {Space} from "antd";
import {json, Link, useParams} from "react-router-dom";
import Hat from "../MainPage/Hat";
import Reg from "./Reg";
import Login from "./Login";
import {Users, x} from "../Data/MockApi";
const LogRegPage = () => {

    let {mode} = useParams();

    return (
        <>
            <Space direction={"vertical"}>
                <Hat/>
            </Space>


            <div style={{textAlign: "center", marginTop: 200}}>
                {mode == 1 ? (<Login/>): <></>}
                {mode == 2 ? (<Reg/>) : <></>}
            </div>
        </>





    )
}

export default LogRegPage;