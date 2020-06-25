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

var slideIndex1 = 1;
var slideIndex2 = 1;

showSlides1(slideIndex1);
showSlides2(slideIndex2);

function plusSlides1(n) {
  showSlides1(slideIndex1 += n);
}

function currentSlide1(n) {
  showSlides1(slideIndex1 = n);
}

function showSlides1(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides1");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex1 = 1}
  if (n < 1) {slideIndex1 = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  
  slides[slideIndex1-1].style.display = "inline";
  var platform = document.getElementById("platform1");
  if (slideIndex1 == 1) {platform.value = "google";}
  if (slideIndex1 == 2) {platform.value = "nate";}
  if (slideIndex1 == 3) {platform.value = "zum";}
}

function plusSlides2(n) {
  showSlides2(slideIndex2 += n);
}

function currentSlide2(n) {
  showSlides2(slideIndex2 = n);
}

function showSlides2(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides2");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex2 = 1}
  if (n < 1) {slideIndex2 = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  
  slides[slideIndex2-1].style.display = "block";
  var platform = document.getElementById("platform2");
  if (slideIndex2 == 1) {platform.value = "google";}
  if (slideIndex2 == 2) {platform.value = "nate";}
  if (slideIndex2 == 3) {platform.value = "zum";}
}

function keywordInsert(n) {
	var keyword = document.getElementById("input_text");
	var text = document.getElementById(n);
	keyword.value = text.innerText;
}