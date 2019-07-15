var Controller = (function() {
    var addButtonClickEvent = function(textTrigger, event) {
        var model = this;
        var value = textTrigger.value.trim();
        if (value.length) {
            if (model.notDuplicate(value)) {
                model.Add(value);
                textTrigger.value = null;
            } else {
                alert("Duplicate value");
            }
        };
    };

    //event is from text trigger
    //invoke click method of addbutton if keycode == 13 which is enter

    var addTextTriggerKeypressEvent = (addButton, event) => {
        if (event.keyCode == 13) {
            addButton.click();
        }
    };
    var deleteButtonClickEvent = function(event) {
        var model = this;
        if (event.target.type == "button") {
            model.Delete(event.target.value);

        }

    }

    var constructor = function() {

        var scopeEl;
        var model;
        var view;

        this.init = (el, m, v) => {
            scopeEl = el;
            model = m;
            view = v;
            model.setScope(el);
            model.setView(view);
            model.registerWidget(view.listView());
            model.registerWidget(view.summaryView());
            model.refreshWidgets(view, model);


            var addButton = view.triggerField().getButtonInstance(el);
            var textTrigger = view.triggerField().getTextInstance(el);

            addButton.addEventListener("click", addButtonClickEvent.bind(model, textTrigger));

            // CG: 06/27/2019
            // needs a unit test
            // adding the keyPress event to the textTrigger
            // the callback gets the addButton, if keyCode == 13, addButton's click() method gets invoke in the callback.
            textTrigger.addEventListener("keypress", addTextTriggerKeypressEvent.bind(model, addButton));

            var listViewEl = scopeEl.getElementsByClassName('listWrapper')[0];
            listViewEl.addEventListener("click", deleteButtonClickEvent.bind(model));

        };

    };

    return new constructor();

});