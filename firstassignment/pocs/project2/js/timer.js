window.onload = init;

function sec2time(timeInSeconds) {
    var pad = function(num, size) { return ('000' + num).slice(size * -1); },
    time = parseFloat(timeInSeconds).toFixed(3),
    hours = Math.floor(time / 60 / 60),
    minutes = Math.floor(time / 60) % 60,
    seconds = Math.floor(time - minutes * 60);

    return pad(hours, 2) + ':' + pad(minutes, 2) + ':' + pad(seconds, 2);
}

            function init() {
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
                        display.innerHTML = "End!";
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
