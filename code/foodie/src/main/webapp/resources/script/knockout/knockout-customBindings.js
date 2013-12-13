
ko.bindingHandlers.fadeInOut = {    
    update: function (element, valueAccessor, allBindingsAccessor) {
        var visible = ko.utils.unwrapObservable(valueAccessor());
        if (visible) {
            $(element).show('fade',500);
        } else {
            $(element).hide('fade', 500);
        }
        
    }
}


ko.bindingHandlers.accordion = {
    init: function (element, valueAccessor, allBindingsAccessor) {
        $(element).accordion();;
    },
    update: function (element, valueAccessor, allBindingsAccessor) {
        $(element).accordion("refresh");;
    }
   
}

//This binding is to make ratings presented as stars
//3 paramters should be parsed as input
//targe_score : the actual rating
//class_name : the unique class name for this rating
//num_of_split : at the moment only support whole-star rating and
//               half-star rating. 
//               when num_of_split <=1 then use whole star
//               when num_of_split > 1 then use half star
ko.bindingHandlers.starRating = {

    maxRate : 5,

    // the initial function is used to draw stars
    init: function(element, valueAccessor) { 

        //retrieve the whole input string
        var observable = valueAccessor();

        //split the input string into 3 parts
        var values = observable.split(" ",3);
        var target_score = values[0];
        var class_name = values[1];
        var num_of_split = values[2];

        // depend on commonFunction.parseDataIntoNumber
        num_of_split = parseDataIntoNumber(num_of_split,2,1);

        var tmp_html = '';

        //if less than or equal to 1 then use the whole star
        if(num_of_split<=1) {
            for( i = 1; i <= 5; i++ ) {
                tmp_html += '<input name="'+class_name+'" type="radio" class="' + 
                class_name + ' star" value="'+ i.toFixed(1)+'"/>';
            }
        }else {  // else use the half star
            for( i = 0.5; i<=5; i+=0.5 ){
               tmp_html += '<input name="'+class_name+'" type="radio" class="' + 
               class_name + ' star {split:2}" value="'+i.toFixed(1)+'"/>'; 
            }
        }

        // retrieve the content before inserting the grey stars
        // eg. the rating score
        old_content = $(element).html();

        //inserting radio input tag for starRating api and also the old elements
        $(element).html(tmp_html+old_content)

        //call the starRating api to draw the grey stars
        $(element).children('input[type=radio].'+class_name).rating();
        
    },

    //the update function is used to highlight the stars
    update: function(element, valueAccessor) {
        //retrieve the whole input string
        var observable = valueAccessor();

        //split the input string into 3 parts
        var values = observable.split(" ",3);
        var target_score = values[0];
        var class_name = values[1];
        var num_of_split = values[2];

        // depend on commonFunction.parseDataIntoNumber
        num_of_split = parseDataIntoNumber(num_of_split,2,1);
        target_score = parseDataIntoNumber(target_score,this.maxRate);

        if (target_score != 0){

            //calculate the index of the star needs to be highlighted
            //the number will be rounded using toFixed(0)
            //eg. target_score*num_of_split = 4.3 * 2 = 8.6
            //eg. (8.6).toFixed(0) = 9 
            //eg. then from the 1st to the 9th half star will be highlighted
            //eg. And the index of the 9th half star is 9-1 = 8
            //eg. if * represents highlighted and '|' to seperate stars 
            //eg. then for score 4.3, it will be |**|**|**|**|*-|
            rate_idx = parseFloat((target_score*num_of_split.toFixed(0)).toFixed(0))-1;

            //call starRating api for highlighting the stars
            $(element).children('input.'+class_name).rating("enable");
            $(element).children('input.'+class_name).rating('select',rate_idx);
            $(element).children('input.'+class_name).rating('disable')
        }
    }
};

