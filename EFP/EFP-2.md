# EFP-2

## Проблематика

— проблемой текущей реализации [container] являются циклические зависимости

- самый простой способ избежать циклических зависимостей, это создать [wrapper]
- при ините [dependency], будет прокидываться [wrapper] а потом в него будет сетиться объект с нужным значением

## Сущности

[wrapper]:
— абстракция, которая умеет оборачивать в себя объекты

[wrapped]:
- объект который оборачиваем

[dynamic_wrapper]:
— вызовы методов прокисруются обернутому объекту, при этом сам [dynamic_wrapper], может подменить [wrapped] на другой, а пользователи [dynamic_wrapper] даже не заметят разницы
