const CLASSNAME = "-visible";
const TIMEOUT = 1500;
const $target = $(".title");

// setInterval(() => {
//   $target.addClass(CLASSNAME);
//   setTimeout(() => {
//     $target.removeClass(CLASSNAME);
//   }, TIMEOUT);
// }, TIMEOUT * 2);
function animateOnce() {
  $target.addClass(CLASSNAME);
  setTimeout(() => {
    $target.removeClass(CLASSNAME);
  }, TIMEOUT);
}

animateOnce();

setTimeout(() => {
  $("#loader").fadeOut(0, () => {
    $("#content").show();
  });
}, 3000);