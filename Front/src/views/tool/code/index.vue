<template>
  <div class="app-container">code</div>
</template>

<script>
export default {
  mounted() {
    const fahrenheitToCelsius = (fahrenheit) => (fahrenheit - 32) * 5 / 9
    fahrenheitToCelsius(50)
    // 10 
    const celsiusToFahrenheit = (celsius) => celsius * 9 / 5 + 32
    celsiusToFahrenheit(100)
    // 212
  }
}
</script>