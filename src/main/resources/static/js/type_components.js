jQuery(document).ready(function ($) {

    var token = $('#_csrf').attr('content');
    var header = $('#_csrf_header').attr('content');


    $(".remove-button").click(function () {

        let url = $(this).parentElement.action;
        let parent = $(this).parentElement.parentElement.parentElement;
        $.ajax({
            url: url,
            method: 'post',
            data: {
                "_csrf": token
            },
            success: (function(data){
                $(this).parentElement.parentElement.parentElement.remove();
            })
        });

    });

    $("#add_typeComponent").click(function (){
        let _key = $("#key").val();
        let _value = $("#value").val();

        $.ajax({
            url: '/type_components',
            method: 'post',
            data: {
                "_csrf": token,
                key: _key,
                value: _value
            },
            success: function (data) {
                let table = $("#table-components");
                let htmlText= `
                    <tr>
                    <th>
                        <form method="post" action="/type_components/delete/${data.key}">
                        <input type="hidden" name="_csrf" value="1cc9e16b-0a5c-48f1-a5a5-9b09acc8451d">
                        <input type="hidden" name="_method" value="delete">
                            <button type="submit" class="btn-sm custom-button remove-button">Удалить</button>
                        </form>
                    </th>
                    <th>${data.key}</th>
                    <th>${data.value}</th>
                    </tr>
                `
                table.append(htmlText);
            }
        });
    });

});