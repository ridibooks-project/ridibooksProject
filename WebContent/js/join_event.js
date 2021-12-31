





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

