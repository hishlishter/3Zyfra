from typing import List
import time


def bubble_sort(values: List[float]) -> List[float]:
    result: List[float] = list(values)
    length: int = len(result)

    if length < 2:
        return result

    for pass_index in range(length - 1):
        has_swaps: bool = False
        last_index_to_check: int = length - 1 - pass_index
        for index in range(last_index_to_check):
            left_value: float = result[index]
            right_value: float = result[index + 1]
            if left_value > right_value:
                result[index], result[index + 1] = right_value, left_value
                has_swaps = True

        if not has_swaps:
            break

    return result


def _parse_input_to_float_list(raw_input: str) -> List[float]:
    tokens = [token for token in raw_input.strip().split(" ") if token != ""]
    return [float(token) for token in tokens]


def main() -> None:
    print("Введите числа через пробел:")
    try:
        user_input = input()
        numbers = _parse_input_to_float_list(user_input)
    except ValueError:
        print(
            "Ошибка: ввод должен содержать только числа (целые или вещественные), разделённые пробелами."
        )
        return

    # Измеряем пузырьковую сортировку
    start_bubble: float = time.perf_counter()
    sorted_numbers_bubble = bubble_sort(numbers)
    bubble_elapsed_s: float = time.perf_counter() - start_bubble

    # Измеряем встроенную сортировку
    start_builtin: float = time.perf_counter()
    sorted_numbers_builtin = sorted(numbers)
    builtin_elapsed_s: float = time.perf_counter() - start_builtin

    # Вывод результата сортировки (по пузырьку)
    print("Отсортированный список:")
    print(" ".join(str(num) for num in sorted_numbers_bubble))

    # Проверяем совпадение результатов
    if sorted_numbers_bubble != sorted_numbers_builtin:
        print("Предупреждение: результаты сортировок различаются!")

    # Сравнение времени
    bubble_ms = bubble_elapsed_s * 1000.0
    builtin_ms = builtin_elapsed_s * 1000.0
    print(f"Время пузырьковой сортировки: {bubble_ms:.3f} мс")
    print(f"Время встроенной сортировки sorted(): {builtin_ms:.3f} мс")
    if builtin_elapsed_s > 0:
        speedup = bubble_elapsed_s / builtin_elapsed_s
        print(f"Ускорение встроенной сортировки: {speedup:.2f}×")


if __name__ == "__main__":
    main()
