$(document).ready(function ($) {


    var token = $('#_csrf').attr('content');
    var header = $('#_csrf_header').attr('content');

    const type_key = window.location.href;
    let data_keys = [];
    $("#type-component").change(function (){

        let key = $(this).val();
        let form = $("#dynamic-elements");
        form.empty();
        data_keys = [];


        $.ajax({
           url: type_key + '/' + key,
           method: 'post',
           data: {
               "_csrf": token
           },
            success: (function(data){
                console.log(data);
                let fields = {};
                fields[key] = {};

                let keys = Object.keys(data['fields']);

                keys.forEach(function (elem) {
                    console.log(elem);
                    data_keys.push(elem);
                    let htmlText = `
                <div style="margin-top: 20px" class="form-group">
                    <label>${data['fields'][elem]['value']}</label>
                    <div class="inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input required="${data['fields'][elem]['required']}" id="${elem}" name="${keys}" placeholder="Введите ${data['fields'][elem]['value']}..." class="form-control" type="text">
                        </div>
                    </div>
                </div>
`
                    form.append(htmlText);
                });
            })
        });
    });

    $("#send_form").click(function (){

        let data = {};
        let url_key = $("#type-component").val();

        data_keys.forEach(element => {
            data[element] = $("#" + element).val();

        });

        $.ajax({
           url:"/add-component/component/" + url_key,
           method: 'post',
           data: {
               "data": JSON.stringify(data),
               "_csrf": token
           },
        });
    });


    $("#type-component").trigger('change');
});