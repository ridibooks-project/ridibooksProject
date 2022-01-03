const swiper_slider_nb = new Swiper('.tr_box', {
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