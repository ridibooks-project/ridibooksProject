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


function countingStar() {
    let star_progress = document.querySelectorAll('.real_star');
    let count_star = document.querySelectorAll('.star_rating');
    for (let i = 0; i < star_progress.length; i++) {
        star_progress[i].style.width = (count_star[i].value * 15.8) + "px";
    }
}
countingStar();
                

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