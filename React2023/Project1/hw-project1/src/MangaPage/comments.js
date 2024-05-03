import {Card, Space} from "antd";

const Comment = (prob) => {
    const {User, Time, Text, MangaId} = prob

    const date = new Date(Time);
    const h = date.getHours()
    const m = date.getMinutes()
    const mo = date.getMonth() + 1
    const d = date.getDate()
    const y = date.getFullYear()

    const text = "sjrgpjpjgposjpojgr";

    return (<div>
        <Card>
            <Space direction={"vertical"}>
                <div>
                    <h2>{User}</h2>
                    <h6>{h + ':' + m + " " + d + "." + mo + "." + y}</h6>
                </div>

                <p>{Text}</p>
            </Space>

        </Card>
    </div>)
}

export default Comment;