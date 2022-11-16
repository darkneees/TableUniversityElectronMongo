$(document).ready(function ($) {

    var token = $('#_csrf').attr('content');
    var header = $('#_csrf_header').attr('content');

    $("#add-element").click(function (){

        let key_field = $("#key-field").val();
        let name_field = $("#name-field").val();
        let required = $('input[name=require]:checked').val();

        if(!fields.hasOwnProperty(key_field)) {

            fields[type_key][key_field] = {
                "value": name_field,
                "required": required
            };

            let htmlText = `
        <tr>
            <th>
                <button class="btn-sm custom-button remove-button">Удалить</button>
            </th>
            <th>${key_field}</th>
            <th>${name_field}</th>
            <th>${required}</th>
        </tr>`

            let tableBody = $("#table-components");
            tableBody.append(htmlText);
        } else alert("This key is already exist");
    });

    $("#table-components").on('click', '.remove-button', function (){
        $(this)[0].parentElement.parentElement.remove();
        delete fields[type_key][$(this)[0].parentElement.nextElementSibling.textContent];
    });

    $("#update_form").click(function (){

        console.log(fields);
        $.ajax({
            url: window.location.href,
            method: 'post',
            dataType: "json",
            data: {
                "_csrf": token,
                "data": JSON.stringify(fields)
            },
            success: (function(data){

            })
        });
    });


});