# language:ru

  Функциональность: Перевод между картами одного пользователя

    Сценарий: Перевод 5000 рублей на 1ю карту(позитивный)
      Пусть пользователь залогинен с именем vasya и паролем qwerty123
      Когда пользователь переводит 5000 рублей с карты с номером 5559 0000 0000 0002 на свою 1 карту с главной страницы
      Тогда баланс его 1 карты из списка на главной странице должен стать 15000 рублей
