$(function(){
  $("#time").datepicker({
    onSelect:function(dateText, inst) {
      console.log(dateText);
      console.log(inst);
    }
  });
  $("#time").datepicker({
    changeYear:true,
    changeMonth:true
    });
});
var slideIndex = 1;

showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  
  slides[slideIndex-1].style.display = "block";
  var platform = document.getElementById("platform2");
  if (slideIndex == 1) {platform.value = "google";}
  if (slideIndex == 2) {platform.value = "nate";}
  if (slideIndex == 3) {platform.value = "zum";}
}

function keywordInsert(n) {
	var keyword = document.getElementById("input_text");
	var text = document.getElementById(n);
	keyword.value = text.innerText;
}