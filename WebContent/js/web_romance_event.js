const swiper_slider_tr = new Swiper('.tr_box', {
    speed: 500,
    debugger: false,
    slidesPerView: 6,
    slidesPerGroup: 6,
    initialSlide: 1,
    loop: true,
    mousewheel: false,
    navigation: {
        nextEl: '.tr_n_btn',
        prevEl: '.tr_p_btn'
    }
});

const swiper_slider_ne = new Swiper('.ne_box', {
    speed: 500,
    debugger: false,
    slidesPerView: 6,
    slidesPerGroup: 6,
    initialSlide: 1,
    loop: true,
    mousewheel: false,
    navigation: {
        nextEl: '.ne_n_btn',
        prevEl: '.ne_p_btn'
    }
});
