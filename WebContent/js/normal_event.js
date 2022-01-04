// 스와이퍼 api 컨트롤러

        
// 회원권한 설정( 로그인 화면 이동 )
let menu_navi = document.querySelectorAll('.menu_navi');
for (let i = 0; i < menu_navi.length; i++){
    if (i > 0) {
        menu_navi[i].onclick = () => {
            window.location = "./account/login.html";
        }
    }
}
menu_navi
// 회원권한 설정( 로그인 화면 이동 )
