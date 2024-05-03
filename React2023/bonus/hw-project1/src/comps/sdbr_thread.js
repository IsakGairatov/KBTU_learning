import SideBar from "./sideBar";
import {Avatar} from "antd";
import "./sdbr_thread.css"

const Sdbr_thread = () => {
    return (
        <div className={"sdbrThread"}>
            <Avatar/>
            <div className={"sdbrThread_d"}>
                <h3>Thread name</h3>
                <p>This is the info</p>
                <small className={"sdbrThread_t"}>timestamp</small>
            </div>

        </div>
    )
}

export default Sdbr_thread