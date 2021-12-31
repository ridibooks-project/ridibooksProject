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

const swiper_slider_nb = new Swiper('.nb_box', {
    speed: 500,
    debugger: false,
    slidesPerView: 6,
    slidesPerGroup: 6,
    initialSlide: 1,
    loop: true,
    mousewheel: false,
    navigation: {
        nextEl: '.sbn_nb',
        prevEl: '.sbp_nb'
    }
});

const swiper_slider_tr = new Swiper('.tr_box', {
    speed: 500,
    debugger: false,
    slidesPerView: 6.3,
    slidesPerGroup: 6,
    initialSlide: 1,
    loop: true,
    mousewheel: false,
    navigation: {
        nextEl: '.sbn_tr',
        prevEl: '.sbp_tr'
    }
});


     

const swiper_slider_wn = new Swiper('.wn_box', {
    speed: 500,
    debugger: false,
    slidesPerView: 6.3,
    slidesPerGroup: 6,
    initialSlide: 1,
    loop: true,
    mousewheel: false,
    navigation: {
        nextEl: '.sbn_wn',
        prevEl: '.sbp_wn'
    }
});

const swiper_slider_i = new Swiper('.i_box', {
    speed: 500,
    debugger: false,
    slidesPerView: 6.3,
    slidesPerGroup: 6,
    initialSlide: 1,
    loop: true,
    mousewheel: false,
    navigation: {
        nextEl: '.sbn_i',
        prevEl: '.sbp_i'
    }
});
// 스와이퍼 api 컨트롤러

// 별점
function countingStar() {
    let star_progress = document.querySelectorAll('.real_star');
    let count_star = document.querySelectorAll('.star_rating');
    for (let i = 0; i < star_progress.length; i++) {
        star_progress[i].style.width = (count_star[i].value * 10.768) + "px";
    }
}
countingStar();
// 별점
           
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
