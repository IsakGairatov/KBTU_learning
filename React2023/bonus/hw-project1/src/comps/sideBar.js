import React from "react";
import {SearchOutlined, EditOutlined} from "@ant-design/icons"
import "./sideBar.css"
import Sdbr_thread from "./sdbr_thread";

const SideBar = () => {
    return (
        <div className={"sdbr"}>
            <div className={"sdbr_header"}>
                <div className={"sdbr_search"}>
                    <SearchOutlined/>
                    <input placeholder={"Search"} className={"sdbr_input"}></input>
                    <button id={"search_btn"}><EditOutlined /></button>
                </div>
            </div>

            <div className={"sdbr_threads"}>
                <Sdbr_thread/>
                <Sdbr_thread/>
                <Sdbr_thread/>
            </div>
            <div className={"sdbr_bottom"}></div>
        </div>
    )
}

export default SideBar