import axios from 'axios';
import React, { useEffect, useState } from 'react';

const UploadList = () => {  
    const [uploadList, setUploadList] = useState([])
    useEffect(()=>{
        
        axios.post(`http://localhost:8080/user/getUploadList`)
        .then(res => {
            setUploadList(res.data)
           
            
            console.log(res.data)
            //res.data를 출력해보면 데이터가 content라는 이름에 들어있는 것을 확인 할 수 있다.
            // => 스프링 부트에서 Page<> 로 리턴했기 때문이다
        })
        .catch(error => console.log(error))
        
    },[])

    return (
        <div>
            <table id="uploadListTable" border="1" frame="hsides" rule="rows">
	<tr>
		<th width="100">번호</th>
		<th width="200">이미지</th>
		<th width="200">이미지 이름</th>
	</tr>
        <tbody>
                    {
                    uploadList.map(item => {
                        return(
                            <tr key={item.seq}>
                                <td>{item.seq}</td>
                                <td>
                                 {item.imgoriginalfilename}
                                </td>
                                <td>{item.imagename}</td>
                            </tr>
                        )
                    })
                }
          </tbody>
       
    </table>
        </div>
    );
};

export default UploadList;