import {UserInfo} from "../Data/Data";
import {Card, Space} from "antd";
import {Posts} from "../Data/Data";
import Post from "./Post";

const Lenta = () => {
    return (
        <div>
            <h1>All posts</h1>

            {Posts.map((el) => <Post {...el}/>)}
        </div>

    )
}

export default Lenta
