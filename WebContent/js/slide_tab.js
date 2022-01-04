const swiper_slider_dk = new Swiper('.dark_box_cont', {
    speed: 500,
    debugger: false,
    slidesPerView: 6,
    slidesPerGroup: 6,
    initialSlide: 1,
    loop: true,
    mousewheel: false,
    navigation: {
        nextEl: '.dk_bg_nav_next',
        prevEl: '.dk_bg_nav_prev'
    }
});

const swiper_slider_wt = new Swiper('.white_box_cont', {
    speed: 500,
    debugger: false,
    slidesPerView: 6,
    slidesPerGroup: 6,
    initialSlide: 1,
    loop: true,
    mousewheel: false,
    navigation: {
        nextEl: '.wt_bg_nav_next',
        prevEl: '.wt_bg_nav_prev'
    }
});

   