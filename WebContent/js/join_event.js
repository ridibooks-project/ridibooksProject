





// 남녀 버튼 클릭시 input값에 value대입
let gender_ip_man = document.querySelector('.gender_ipm');
let gender_ip_woman = document.querySelector('.gender_ipw');

let gender_input = document.querySelector('.gender_input');


gender_ip_man.onclick = () => {
    gender_ip_man.style.backgroundColor = "#1f8ce6";
    gender_ip_woman.style.backgroundColor = "white";
    gender_ip_man.style.color = "white";
    gender_ip_woman.style.color = "black";
    gender_input.setAttribute('value', '남');
}

gender_ip_woman.onclick = () => {
    gender_ip_man.style.backgroundColor = "white";
    gender_ip_woman.style.backgroundColor = "#1f8ce6";
    gender_ip_man.style.color = "black";
    gender_ip_woman.style.color = "white";
    gender_input.setAttribute('value', '여');
}
// 남녀 버튼 클릭시 input값에 value대입

// 체크박스 설정
let check_blue = document.querySelectorAll('.check_blue');
let check_gray = document.querySelectorAll('.check_gray');

let checkbox_style = document.querySelectorAll('.checkbox_style');

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
    checkbox_style[inputVariable].setAttribute('value', "on");
    checkbox_style[inputVariable].checked = true;
}
for (let i = 0; i < checkbox_style.length; i++){
    if (i == 0) {
        check_gray[i].onclick = () => {
            check_on(i)
            for (let j = 1; j < 4; j++){
                check_on(j);
            }
        }
        check_blue[i].onclick = () => {
            check_off(i) 
            for (let j = 1; j < 4; j++){
                check_off(j); 
            }
        }
    }else {
        check_gray[i].onclick = () => {
            check_on(i)
            eo_chbox_click();
        }
        check_blue[i].onclick = () => {
            check_off(i) 
            eo_chbox_click();
        }

        
    
    }
}



// 체크박스 설정