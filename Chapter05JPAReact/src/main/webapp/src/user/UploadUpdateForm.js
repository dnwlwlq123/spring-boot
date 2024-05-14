import axios from 'axios';
import React, { useEffect, useRef, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import cameraImg from '../image/camera.png'
const UploadUpdateForm = () => {
    const {seq} = useParams()

    const [userUploadDTO, setUserUploadDTO] = useState({
        imageName: '',
        imageContent: '',
        imageFileName: '',
        imageOriginalFileName: '',
    })
    const {imageName, imageContent, imageFileName, imageOriginalFileName} = userUploadDTO

    const [files, setFiles] = useState([])
    const imgRef = useRef()
    const navigate = useNavigate();

    useEffect(()=>{
        axios.get(`http://localhost:8080/user/getUploadImage?seq=${seq}`)
        .then(res => {
            console.log(res.data)
            setUserUploadDTO(res.data)
        })
        .catch()
    },[])
    const onCamera = () => {
        imgRef.current.click()
    }

    const onInput = (e) => {
        setUserUploadDTO({
            ...userUploadDTO,
            [e.target.name] : e.target.value
        })
    }

    const onUploadSubmit = (e) => {
        e.preventDefault()

        var formData = new FormData()
        {/* 
            formData.append() 사용하여 FormData에 데이터를 추가하는데, 
            new Blob([JSON.stringify(userUploadDTO)], {type: 'application/json}) 부분은
            JSON 데이터를 Blod 객체로 변환하여 FormData에 추가하는 것을 나타낸다

            [JSON.stringify(userUploadDTO)는 javascript 객체인 DTO를 Json 문자열로 변환한다.
            이렇게 하면 객체의 속성과 값을 JSON 형식으로 표현할 수 있다.

            ])
        */}

        formData.append("seq",seq)


        formData.append(
            "userUploadDTO",
             new Blob([JSON.stringify(userUploadDTO)], {type : 'application/json'})
        )

        for(var i=0 ; i<files.length ; i++){
            formData.append("img",files[i])
        }


        console.log(formData)
    }

    return (
        <div>
            <a href="/">
                    <img src="/logo512.png" height="50px" alt="자연"/>
            </a>
            <form id="uploadUpdateForm">
	
	<table border="1">
		<tr>
			<th>상품명</th>
			<td>
				<input type="text" name="imageName" value={imageName} onChange={onInput} size="35"/>
			</td>
		</tr>
			
		<tr>
			<td colspan="2">
				<textarea name="imageContent" value={imageContent}onChange={onInput}  rows="10" cols="50"></textarea>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
			<span id="showImgList">
            <img src={`https://kr.object.ncloudstorage.com/bitcamp-6th-bucket-80/storage/${userUploadDTO.imageFileName}`} alt={imageName}
                        style={{width: '70px', height: '70px'}}/>
            </span>
			<img src={cameraImg} id="camera" alt="카메라" width="50px" height="50px" onClick={onCamera}/>
				<input type="file" name="img" id="img"  style={{visibility: 'hidden'}}/>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="목록" onclick={()=>navigate('/user/uploadList')}/> &nbsp;
				<input type="button" value="수정" onClick={onUploadSubmit}/>
				<input type="reset" value="취소" />
			</td>
		</tr>
	</table>
</form>
        </div>
    );
};

export default UploadUpdateForm;