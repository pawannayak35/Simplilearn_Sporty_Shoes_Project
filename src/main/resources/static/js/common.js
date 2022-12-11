/**
 * 
 */
const navbar = document.querySelector(".navbarCus");
const menuBtn = document.querySelector(".menu-btn");
const cancelBtn = document.querySelector(".cancel-btn");
// const emailTell = document.querySelector(".emailTell");

menuBtn.onclick = () => {
  navbar.classList.add("show");
  // bannerContent.classList.add("hide");
};
cancelBtn.onclick = () => {
  navbar.classList.remove("show");
  // bannerContent.classList.remove("hide");
};

window.onscroll = () => {
  this.scrollY > 20
    ? navbar.classList.add("sticky")
    : navbar.classList.remove("sticky");
};