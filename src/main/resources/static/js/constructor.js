$(document).ready(function ($) {

    var token = $('#_csrf').attr('content');
    var header = $('#_csrf_header').attr('content');

    $("#add-element").click(function (){

        let name_field = $("#name-field").val();
        let required = $('input[name=require]:checked').val();
        let type_data = $("#type_data option:selected").text();

        if(type_data === "Выбери тип данных") alert("Вы не выбрали тип данных.");
        else {
            if(!fields[type_key].hasOwnProperty(name_field)) {

                fields[type_key][name_field] = {
                    "typeData": type_data,
                    "required": required
                };

                let htmlText = `
        <tr>
            <th>
                <button class="btn-sm custom-button remove-button">Удалить</button>
            </th>
            <th>${name_field}</th>
            <th>${type_data}</th>
            <th>${required}</th>
        </tr>`

                let tableBody = $("#table-components");
                tableBody.append(htmlText);
                console.log(fields);
            } else alert("Это значение уже существует");
        }
    });

    $("#table-components").on('click', '.remove-button', function (){
        $(this)[0].parentElement.parentElement.remove();
        delete fields[type_key][$(this)[0].parentElement.nextElementSibling.textContent];
    });

    $("#update_form").click(function (){

        $.ajax({
            url: window.location.href,
            method: 'post',
            dataType: "json",
            data: {
                "_csrf": token,
                "data": JSON.stringify(fields)
            },
            success: (function(data){
                location.reload();
            })
        });
    });


});