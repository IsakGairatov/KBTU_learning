import {Space} from "antd";


const Character = (proms) => {
    return ( <Space direction="vertical">
            <img src={proms.imgl} width={140}/>
            <b><h>{proms.name}</h></b>
        </Space>
    )
}

export default Character;