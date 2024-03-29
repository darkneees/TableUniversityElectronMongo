jQuery(document).ready(function ($) {

    var token = $('#_csrf').attr('content');
    var header = $('#_csrf_header').attr('content');


    $(".remove-button").click(function () {

        let elem = $(this);
        let url = elem[0].previousElementSibling.action;
        $.ajax({
            url: url,
            method: 'post',
            dataType: "json",
            data: {
                "_csrf": token
            },
            success: (function(data){
                elem[0].parentElement.parentElement.remove();
            })
        });
    });

    $("#add_typeComponent").click(function (){
        let _value = $("#value").val();

        $.ajax({
            url: '/type_components',
            method: 'post',
            data: {
                "_csrf": token,
                value: _value
            },
            success: function (data) {
                let table = $("#table-components");
                let htmlText= `
                    <tr>
                    <th>
                        <form method="post" action="/type_components/delete/${data.key}">
                            <button class="btn-sm custom-button remove-button">Удалить</button>
                        </form>
                    </th>
                    <th>${data.key}</th>
                    <th>${data.value}</th>
                    <th>
                    <a href="/type_components/constructor/${data.key}" class="btn-sm custom-button edit-button">Редактировать конструктор</a>
                    </th>
                    </tr>
                `
                table.append(htmlText);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("Заполните все поля");
            }
        });
    });

});