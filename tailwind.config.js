module.exports = {
    purge: [
        './src/main/resources/templates/*.html',
        './src/main/resources/templates/fragments/*.html',
    ],
    theme: {
        extend: {},
    },
    variants: {},
    plugins: [],
    future: {
        removeDeprecatedGapUtilities: true,
        purgeLayersByDefault: true
    }
}
