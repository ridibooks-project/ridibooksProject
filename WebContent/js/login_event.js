let id_ip = document.querySelector('.id_ip');
let pw_ip = document.querySelector('.pw_ip');
let login_btn = document.querySelector('.login_btn');
let ch_ip = document.querySelector('.ch_ip');

window.onload = function () {
    if (getCookie("id")) { // getCookie함수로 id라는 이름의 쿠키를 불러와서 있을경우
        id_ip.value = getCookie("id"); //input 이름이 id인곳에 getCookie("id")값을 넣어줌
        document.querySelector('.ch_ip').checked = true; // 체크는 체크됨으로
    }
}

function setCookie(name, value, expiredays) //쿠키 저장함수
{
    var todayDate = new Date();
    todayDate.setDate(todayDate.getDate() + expiredays);
    document.cookie = name + "=" + escape(value) + "; path=/; expires="
            + todayDate.toGMTString() + ";"
}

function getCookie(Name) { // 쿠키 불러오는 함수
    var search = Name + "=";
    if (document.cookie.length > 0) { // if there are any cookies
        offset = document.cookie.indexOf(search);
        if (offset != -1) { // if cookie exists
            offset += search.length; // set index of beginning of value
            end = document.cookie.indexOf(";", offset); // set index of end of cookie value
            if (end == -1)
                end = document.cookie.length;
            return unescape(document.cookie.substring(offset, end));
        }
    }
}

//로그인 버튼 클릭시
login_btn.onclick = e => {
    e.preventDefault();
    if (!id_ip.value) { //아이디를 입력하지 않으면.
        alert('임시');
        return;
    }
    if (!pw_ip.value) { //패스워드를 입력하지 않으면.
        alert('임시1');
        return;
    }
    if (ch_ip.checked == true) { // 아이디 저장을 체크 하였을때
        setCookie("id", id_ip.value, 7); //쿠키이름을 id로 아이디입력필드값을 7일동안 저장
    } else { // 아이디 저장을 체크 하지 않았을때
        setCookie("id", id_ip.value, 0); //날짜를 0으로 저장하여 쿠키삭제
    }
    document.getElementById('#login_form').submit(); //유효성 검사가 통과되면 서버로 전송.
}
//https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=javaking75&logNo=140192248783 참조
