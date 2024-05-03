import "./Thread.css"
import {Avatar} from "antd/lib";
import {useState} from "react";

const Thread = () => {
    const [input, setinput] = useState('')
    const sendMess = (event) => {
        event.preventDefault();
        setinput('')
    }

    return (
        <div className={"Thrd"}>
            <div className={"Thrd_h"}>
                <div className={"Thrd_cont"}>
                    <Avatar/>
                    <div className={"Thrd_cont_info"}>
                        <h4>Thread name</h4>
                        <h5>Last seen</h5>
                    </div>
                </div>
            </div>
            <div className={"Thrd_message"}>

            </div>
            <div className={"Thrd_input"}>
                <input placeholder={"message"}/>
                <button onClick={sendMess}>Send</button>
            </div>
        </div>
    )
}

export default Thread