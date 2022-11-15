function drop_pages() {
    document.getElementById("dropdown-pages").classList.toggle("show");
}

function drop_links(){
    document.getElementById("dropdown-links").classList.toggle("show");

}

window.onclick = function(event) {
    if (!event.target.matches('.functiondropbtn')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}

jQuery(document).ready(function ($) {

    $('table').wrap('<div class="big-table"></div>');

    function resize_table_box() {
        $('.big-table').each(function () {
            var box_width = $(this).outerWidth();
            var table_width = $(this).children('table').prop('scrollWidth');
            $(this).removeClass('scroll-left');
            if (table_width > box_width) {
                $(this).addClass('scroll-right');
            } else {
                $(this).removeClass('scroll-right');
            }
        });
    }

    resize_table_box();
    $(window).on('resize', function () {
        resize_table_box();
    });

    $('.big-table table').on('scroll', function () {
        var parent = $(this).parent();
        if ($(this).scrollLeft() + $(this).innerWidth() >= $(this)[0].scrollWidth) {
            if (parent.hasClass('scroll-right')) {
                parent.removeClass('scroll-right');
            }
        } else if ($(this).scrollLeft() === 0) {
            if (parent.hasClass('scroll-left')) {
                parent.removeClass('scroll-left');
            }
        } else {
            if (!parent.hasClass('scroll-right')) {
                parent.addClass('scroll-right');
            }
            if (!parent.hasClass('scroll-left')) {
                parent.addClass('scroll-left');
            }
        }
    });

    var token = $('#_csrf').attr('content');
    var header = $('#_csrf_header').attr('content');

    $(".take-button").click(function () {

        var button = $(this);
        var amount = $(this).nextAll('.amount-elements').val();
        var url = $(this).attr('data-url');

        send_amount(button, url, amount * -1)
    });

    $(".pick-button").click(function () {
        var button = $(this);
        var amount = $(this).nextAll('.amount-elements').val();
        var url = $(this).attr('data-url');

        send_amount(button, url, amount * 1)
    });

    function send_amount(button, url, number) {

        $.ajax({
            type: "POST",
            url: url,
            data: {
                "_csrf": token,
                "amount": number
            },
            success: function (result) {
                let elem = button.parent().parent().parent();
                let amount = elem.find("th[name='amount']");
                amount.text(result.amount);
            },
            error: function () {
                alert("Недостаточно компонентов!");
            }
        });
    }


    $("#item-search").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#table-components tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});