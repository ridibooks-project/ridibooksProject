const swiper_slider = new Swiper('.swiper-container', {
    speed: 500,
    debugger: false,
    slidesPerView: 2.5,
    spaceBetween: 3,
    loop: true,
    mousewheel: true,
    centeredSlides: true,

    autoplay: { 
        delay: 60000
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
