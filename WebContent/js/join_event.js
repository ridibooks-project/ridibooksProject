// 호이스팅
// all input style
let ji_style = document.querySelectorAll('.ji_style');
let error_m_i = document.querySelectorAll('.error_m_i');
let error_require = document.querySelectorAll('.error_require');
let error_wrong = document.querySelectorAll('.error_wrong');
let error_unequal = document.querySelectorAll('.error_unequal');
let error_special = document.querySelectorAll('.error_special');
let error_alreadyUse = document.querySelectorAll('.error_alreadyUse');
let input_guide = document.querySelectorAll('.input_guide');
// all input style
//아이디
let id_input = document.querySelector('.join_id_input');
//아이디
//비밀번호
let pw_input = document.querySelector('.join_pw_input');
let rpw_input = document.querySelector('.join_rpw_input');
//비밀번호
// 남녀 버튼 
let gender_ip_man = document.querySelector('.gender_ipm');
let gender_ip_woman = document.querySelector('.gender_ipw');
let gender_input = document.querySelector('.gender_input');

// 남녀 버튼 
// 체크박스 
let check_blue = document.querySelectorAll('.check_blue');
let check_gray = document.querySelectorAll('.check_gray');
let checkbox_style = document.querySelectorAll('.checkbox_style');
let opacity_mo_event = document.querySelectorAll('.opacity_mo_event');
function eo_chbox_click() {
    if (checkbox_style[1].checked == true && checkbox_style[2].checked == true && checkbox_style[3].checked == true) {
        check_gray[0].style.display = "none";
        check_blue[0].style.display = "inline-block";
        checkbox_style[0].setAttribute('value', "on");
        checkbox_style[0].checked = true;
    } else {
        check_blue[0].style.display = "none";
        check_gray[0].style.display = "inline-block";
        checkbox_style[0].setAttribute('value', "off");
        checkbox_style[0].checked = false;
    }
}
function check_on(inputVariable) {
    check_gray[inputVariable].style.display = "none";
    check_blue[inputVariable].style.display = "inline-block";
    checkbox_style[inputVariable].setAttribute('value', "on");
    checkbox_style[inputVariable].checked = true;
}
function check_off(inputVariable) {
    check_blue[inputVariable].style.display = "none";
    check_gray[inputVariable].style.display = "inline-block";
    checkbox_style[inputVariable].setAttribute('value', "off");
    checkbox_style[inputVariable].checked = false;
}
// 체크박스
// 호이스팅
//모든 input
for (let i = 0; i < 6; i++){
    ji_style[i].onkeydown = e => {
        var e = window.event || e;
        var key = e.keyCode;
         if (key == 32) {
          e.preventDefault();
         }
    }
}
//모든 input
 
// 아이디 input
id_input.onclick = () => {
    id_input.style.border = "1px solid #1F8CE6";
    id_input.classList.remove('redLinePlaceholder');
    input_guide[0].style.display = "inline-block";
    input_guide[0].innerHTML = "5~20자 영문,숫자 입력";
    input_guide[0].style.color = "#1f8ce6";
}

id_input.onblur = () => {
    if (id_input.value.length == 0) {
        error_m_i[0].style.display = "inline-block";
        error_wrong[0].style.display = "none";
        error_require[0].style.display = "inline-block";
        id_input.style.border = "1px solid #E64938";
        id_input.classList.add('redLinePlaceholder');
        input_guide[0].style.display = "none";
    } else if (id_input.value.length < 5) {
        error_m_i[0].style.display = "inline-block";
        error_wrong[0].style.display = "inline-block";
        error_require[0].style.display = "none";
        id_input.style.border = "1px solid #E64938";
        input_guide[0].style.display = "inline-block";
        input_guide[0].innerHTML = "아이디"
        input_guide[0].style.color = "#E64938";
    } else {
        error_m_i[0].style.display = "none";
        error_require[0].style.display = "none";
        error_wrong[0].style.display = "none";
        id_input.style.border = "1px solid #D6DEEB";
        input_guide[0].style.display = "inline-block";
        input_guide[0].innerHTML = "아이디";
        input_guide[0].style.color = "#738096";
        id_input.classList.remove('redLinePlaceholder');
    }
}
// 아이디 input

// 비밀번호 input

pw_input.onclick = () => {
    pw_input.style.border = "1px solid #1F8CE6";
    pw_input.classList.remove('redLinePlaceholder');
    input_guide[1].style.display = "inline-block";
    input_guide[1].innerHTML = "8자 이상, 영문/숫자/특수문자중 2가지 이상 입력";
    input_guide[1].style.color = "#1f8ce6";
}

pw_input.onblur = () => {
    if (pw_input.value.length == 0) {
        error_m_i[1].style.display = "inline-block";
        error_wrong[1].style.display = "none";
        error_require[1].style.display = "inline-block";
        pw_input.style.border = "1px solid #E64938";
        pw_input.classList.add('redLinePlaceholder');
        input_guide[1].style.display = "none";
    } else if (pw_input.value.length < 8) {
        error_m_i[1].style.display = "inline-block";
        error_wrong[1].style.display = "inline-block";
        error_require[1].style.display = "none";
        pw_input.style.border = "1px solid #E64938";
        input_guide[1].style.display = "inline-block";
        input_guide[1].innerHTML = "비밀번호"
        input_guide[1].style.color = "#E64938";
    } else {
        error_m_i[1].style.display = "none";
        error_require[1].style.display = "none";
        error_wrong[1].style.display = "none";
        pw_input.style.border = "1px solid #D6DEEB";
        input_guide[1].style.display = "inline-block";
        input_guide[1].innerHTML = "비밀번호";
        input_guide[1].style.color = "#738096";
        id_input.classList.remove('redLinePlaceholder');
    }
}
rpw_input


// 비밀번호 input

// 남녀 버튼 클릭시 input값에 value대입
gender_ip_man.onclick = () => {
    gender_ip_man.style.backgroundColor = "#DBEFFF";
    gender_ip_woman.style.backgroundColor = "white";
    gender_input.setAttribute('value', '남');
}

gender_ip_woman.onclick = () => {
    gender_ip_man.style.backgroundColor = "white";
    gender_ip_woman.style.backgroundColor = "#DBEFFF";
    gender_input.setAttribute('value', '여');
}

gender_ip_man.onmouseover = () => {
    gender_ip_man.style.border = '1px solid black';
}

gender_ip_man.onmouseout = () => {
    gender_ip_man.style.borderTop = '1px solid #D6DEEB';
    gender_ip_man.style.borderRight = 'none';
    gender_ip_man.style.borderBottom = '1px solid #D6DEEB';
    gender_ip_man.style.borderLeft = '1px solid #D6DEEB';
}

gender_ip_woman.onmouseover = () => {
    gender_ip_woman.style.border = '1px solid black';
}

gender_ip_woman.onmouseout = () => {
    gender_ip_woman.style.border = '1px solid #D6DEEB';
}
// 남녀 버튼 클릭시 input값에 value대입

// 체크박스 설정
for (let i = 0; i < checkbox_style.length; i++){
    if (i == 0) {
        check_gray[i].onclick = () => {
            check_on(i);
            for (let j = 1; j < 4; j++){
                check_on(j);
            }
        }
        check_blue[i].onclick = () => {
            check_off(i);
            for (let j = 1; j < 4; j++){
                check_off(j); 
            }
        }
    }else {
        check_gray[i].onclick = () => {
            check_on(i);
            eo_chbox_click();
        }
        check_blue[i].onclick = () => {
            check_off(i);
            eo_chbox_click();
        }
    }
    opacity_mo_event[i].onclick = () => {
        if (checkbox_style[i].value == "off") {
                if (i == 0) {
                    for (let j = 1; j < 4; j++){
                        check_on(j);
                    }
                }
                check_on(i);
        } else if(checkbox_style[i].value == "on") {  
                if (i == 0) {
                    for (let j = 1; j < 4; j++){
                        check_off(j);
                    }
                }
            check_off(i);
        }     
    }

    check_blue[i].onmouseover = () => {
        opacity_mo_event[i].style.opacity = "1";
    }
    check_gray[i].onmouseover = () => {
        opacity_mo_event[i].style.opacity = "1";
    }
    check_blue[i].onmouseout = () => {
        opacity_mo_event[i].style.opacity = "0.6";
    }
    check_gray[i].onmouseout = () => {
        opacity_mo_event[i].style.opacity = "0.6";
    }
    opacity_mo_event[i].onmouseover = () => {
        opacity_mo_event[i].style.opacity = "1";
    }
    opacity_mo_event[i].onmouseout = () => {
        opacity_mo_event[i].style.opacity = "0.6";
    }
}
// 체크박스 설정