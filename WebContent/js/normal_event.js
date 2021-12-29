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
    slidesPerView: 5,
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
    navigation: {
        nextEl: '.sbn_nb',
        prevEl: '.sbp_nb'
    }
});