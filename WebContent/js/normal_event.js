const swiper_slider = new Swiper('.swiper-container', {
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
        el: '.swiper-pagination',
        type: 'fraction'
    },
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev'
    }
});
