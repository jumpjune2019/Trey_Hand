$.ready(function() {
  $.get('title').innerHTML = $.string.format("Quiz Game version {0}", $.getVersion());
});

window.addEventListener("load", init, false);


function sec2time(timeInSeconds) {
    var pad = function(num, size) { return ('000' + num).slice(size * -1); },
    time = parseFloat(timeInSeconds).toFixed(3),
    hours = Math.floor(time / 60 / 60),
    minutes = Math.floor(time / 60) % 60,
    seconds = Math.floor(time - minutes * 60);

    return pad(hours, 2) + ':' + pad(minutes, 2) + ':' + pad(seconds, 2);
}


function init() {

  //retrieving information from JSON file
  var xhr = new XMLHttpRequest();

  xhr.successCallBack = function () {
    var obj = JSON.parse(xhr.responseText);

    //writing terms to page
    var termArea = document.getElementsByClassName("dragTerm");
    var definitionArea = document.getElementsByClassName("termDef");
    var numTerms = termArea.length;

    var counter = 0;
    var answerArray = [];
    var termArray = [];
    var defArray = [];

    //randomize terms by a random array of nums (use Math.random() ). This num will represent the index in the JSON array
    //do-while loop is here for extendability -- in case quiz should need to be extended to more than 5 terms
    do {
      var randomNum = Math.floor(Math.random() * Object.keys(obj).length) + 1;
      if (!answerArray.includes(randomNum)) {
        answerArray.push(randomNum);
      }
    }while(answerArray.length < numTerms)

    //takes the answer array and randomly sorts them into a term array
    do {
      var randomNum = Math.floor(Math.random() * numTerms);
      if(!termArray.includes(randomNum)) {
        termArray.push(randomNum);
      }
    }while(termArray.length < numTerms)

    //now do the same thing for definitions on the page
    do {
      var randomNum = Math.floor(Math.random() * numTerms);
      if(!defArray.includes(randomNum)) {
        defArray.push(randomNum);
      }
    }while(defArray.length < numTerms)

    //render JSON object in the term and def slots
    for(var key in obj) {
      termArea[termArray[counter]].innerHTML = obj[answerArray[counter]].term;
      definitionArea[defArray[counter]].innerHTML = obj[answerArray[counter]].definition;
      counter++;
      if(counter >= 5) {
        break;
      }
    }
  }

  //call back is not successful
  xhr.failureCallBack = function () {
    console.log('Callback failed. Status: ' + xhr.status);
  }

  //COPIED FROM simple_ajax.js (in class example)
  // setting up the file to load
	// this will fail
	// xhr.open('GET', 'data/simple_ajax_1.json');
	xhr.open('GET', 'data/terms.json');
	// setting up the event and wait for the file to load
	// students will look up this event and figure out how to trigger it!
  xhr.onerror = function() {
    console.log("Oh crap! Poop has hit the fan!!");
    console.log("status = " + xhr.status);
  };
  xhr.onload = function() {
    if (xhr.status === 200) {
      xhr.successCallBack();
    }
    else {
      xhr.failureCallBack();
    }
  };
  //invoking the AJAX call
  xhr.send();


  //drag and drop functionality (expanded from in-class examples)
  /*
  var dragItem1 = $.get('drag1');
  var dragItem2 = $.get('drag2');
  var dragItem3 = $.get('drag3');
  var dragItem4 = $.get('drag4');
  var dragItem5 = $.get('drag5');

  var dropArea1 = $.get('drop1');
  var dropArea2 = $.get('drop2');
  var dropArea3 = $.get('drop3');
  var dropArea4 = $.get('drop4');
  var dropArea5 = $.get('drop5');
  */
  //better option:
  var dragItems = document.getElementsByClassName("dragTerm");

  var dropAreas = document.getElementsByClassName("termDrop");

  //copied from drag and drop class example
  function startDragItemFunc(e) {
    e.dataTransfer.setData("text", e.target.id);
  }

  function dropItemFunc(e) {
    e.preventDefault();
    var data = e.dataTransfer.getData("text");
    var dragEl = document.getElementById(data);
    if(e.target.innerHTML === "") {
      e.target.innerHTML = dragEl.innerHTML;
      dragEl.innerHTML = "";
    }
  }

  function dragOverItemFunc(e) {
    e.preventDefault();
  }
  /*
  dragItem1.addEventListener("dragstart", startDragItemFunc, false);
  dragItem2.addEventListener("dragstart", startDragItemFunc, false);
  dragItem3.addEventListener("dragstart", startDragItemFunc, false);
  dragItem4.addEventListener("dragstart", startDragItemFunc, false);
  dragItem5.addEventListener("dragstart", startDragItemFunc, false);

  dropArea1.addEventListener("drop", dropItemFunc, false);
  dropArea2.addEventListener("drop", dropItemFunc, false);
  dropArea3.addEventListener("drop", dropItemFunc, false);
  dropArea4.addEventListener("drop", dropItemFunc, false);
  dropArea5.addEventListener("drop", dropItemFunc, false);

  dropArea1.addEventListener("dragover", dragOverItemFunc, false);
  dropArea2.addEventListener("dragover", dragOverItemFunc, false);
  dropArea3.addEventListener("dragover", dragOverItemFunc, false);
  dropArea4.addEventListener("dragover", dragOverItemFunc, false);
  dropArea5.addEventListener("dragover", dragOverItemFunc, false);
  */
  //better option: iterate using for loop
  for (var i = 0; i < dragItems.length; i++) {
    dragItems[i].addEventListener("dragstart", startDragItemFunc, false);
  }

  for (var i = 0; i < dropAreas.length; i++) {
    dropAreas[i].addEventListener("drop", dropItemFunc, false);
  }
  for (var i = 0; i < dropAreas.length; i++) {
    dropAreas[i].addEventListener("dragover", dragOverItemFunc, false);
  }


  //TIMER SECTION
  var btn = document.getElementById("startBtn");
  var state = "start";
  var display = document.getElementById("timer");
  var timerId;

  function timer() {


      function start() {
          var count = 0;

          function showTime() {
              count++;
              var timer = sec2time(count);
              display.innerHTML = timer;
          }

          timerId = setInterval(showTime, 1000);

      }

      function end() {
          clearInterval(timerId);

      }

      if(state == "start") {
          state = "end";
          btn.innerHTML = "End";
          start();
      } else {
          state = "start";
          btn.innerHTML = "Start";
          end();
      }

  }

  btn.addEventListener("click", timer, false);


}
