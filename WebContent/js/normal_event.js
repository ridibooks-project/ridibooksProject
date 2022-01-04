// 스와이퍼 api 컨트롤러
const swiper_slider = new Swiper('.event_box', {
    speed: 500,
    debugger: false,
    slidesPerView: 2.755,
    spaceBetween: 30,
    loop: true,
    mousewheel: false,
    centeredSlides: true,
    effect: 'coverflow',
    coverflowEffect: {
        rotate: 0,
        slideShadows: true,
        stretch: 0,
      },
    autoplay: { 
        delay: 10000
    },
    pagination: {
        el: '.ev_pn',
        type: 'fraction'
    },
    navigation: {
        nextEl: '.sbn',
        prevEl: '.sbp'
    }
});

        
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
